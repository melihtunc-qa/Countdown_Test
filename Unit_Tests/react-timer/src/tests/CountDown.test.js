import React from 'react';
import { shallow } from 'enzyme';
import Timer from '../components/Timer/Timer';
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

describe('Application Tests', () => {
  it('initializes with correct values', () => {
    const wrapper = shallow(<Timer />);
    expect(wrapper.state('minutes')).toBe(25);
    expect(wrapper.state('seconds')).toBe(0);
    expect(wrapper.state('isOn')).toBe(false);
  });

  it('starts the timer when Start button is clicked', () => {
    const wrapper = shallow(<Timer />);
    wrapper.find('.start-timer').simulate('click');
    setTimeout(() => {
        expect(wrapper.state('isOn')).toBe(true);
    done();
    } , 1000)
  });

  it('stops the timer when Stop button is clicked', () => {
    const wrapper = shallow(<Timer />);
    wrapper.find('.stop-timer').simulate('click');
    expect(wrapper.state('isOn')).toBe(false);
  });

  it('resets the timer when Reset button is clicked', () => {
    const wrapper = shallow(<Timer />);
    wrapper.find('.reset-timer').simulate('click');
    expect(wrapper.state('minutes')).toBe(25);
    expect(wrapper.state('seconds')).toBe(0);
  });
});

