import React from 'react';
import { shallow } from 'enzyme';
import TimerButton from '../components/TimerButton/TimerButton';
import { configure } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

describe('TimerButton Component', () => {
  it('renders without crashing', () => {
    const wrapper = shallow(<TimerButton buttonAction={() => {}} buttonValue="Start" />);
    expect(wrapper).toMatchSnapshot();
  });

  it('invokes buttonAction when clicked', () => {
    const mockButtonAction = jest.fn();
    const wrapper = shallow(<TimerButton buttonAction={mockButtonAction} buttonValue="Start" />);

    wrapper.find('.button-container').simulate('click');
    expect(mockButtonAction).toHaveBeenCalled();
  });
});
