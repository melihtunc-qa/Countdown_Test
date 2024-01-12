import React from 'react';
import { shallow } from 'enzyme';
import Timer from '../components/Timer/Timer';
import TimerButton from '../components/TimerButton/TimerButton';
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

describe('Timer Component', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<Timer />);
    expect(wrapper).toMatchSnapshot();
  });

  it('starts the timer', () => {
    const wrapper = shallow(<Timer />);
    wrapper.instance().startTimer();
    expect(wrapper.state('isOn')).toBe(true);
  });

  it('stops the timer', () => {
    const wrapper = shallow(<Timer />);
    wrapper.instance().stopTimer();
    expect(wrapper.state('isOn')).toBe(false);
  });

  it('resets the timer', () => {
    const wrapper = shallow(<Timer />);
    wrapper.instance().resetTimer();
    expect(wrapper.state('minutes')).toBe(25);
    expect(wrapper.state('seconds')).toBe(0);
  });
});
